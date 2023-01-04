package com.agri.mis.controller.open;

import com.agri.mis.domain.BatchCycle;
import com.agri.mis.service.BatchCycleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
// 控制类
@RestController
// 日志
@Slf4j
// 请求路径
@RequestMapping("/open/batch/cycle")
public class OpenBatchCycleController {

    @Autowired
    private BatchCycleService batchCycleService;

    // 根据id查询数据
    @GetMapping("/{id}")
    public Mono<ResponseEntity<BatchCycle>> find(@PathVariable Long id){
        return batchCycleService.findById(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // 分页查询
    @GetMapping("/pageQuery")
    public Mono<Page<BatchCycle>>pageQuery(@RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("size") int size){
        return batchCycleService.pageQuery(name, PageRequest.of(page, size));
    }


     // 添加数据
    @PostMapping("/save")
    public Mono<BatchCycle> save(@RequestBody BatchCycle batchCycle){
        return batchCycleService.add(batchCycle);
    }



    // 修改数据
    @PutMapping("/{id}")
    public Mono<BatchCycle>update(@PathVariable Long id,@RequestBody BatchCycle batchCycle){
        return batchCycleService.update(id,batchCycle);
    }


    // 删除数据
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id){
        return batchCycleService.findById(id).flatMap(s -> batchCycleService.delete(s))
                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
       .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
