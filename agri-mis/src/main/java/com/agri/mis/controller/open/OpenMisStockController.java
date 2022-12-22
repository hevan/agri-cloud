package com.agri.mis.controller.open;

import com.agri.mis.domain.MisStock;
import com.agri.mis.dto.MisStockWithStoreCorp;
import com.agri.mis.service.MisStockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
// 控制类
@RestController
// 日志打印
@Slf4j
// 路径请求
@RequestMapping("/open/mis/stock")
public class OpenMisStockController {

    @Autowired
    private MisStockService misStockService;

    // 根据id查询数据
    @GetMapping("/{id}")
    public Mono<ResponseEntity<MisStock>> findById(@PathVariable Long id){
        return misStockService.findById(id)
                .map(ResponseEntity::ok)
                        .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // 分页查询
    @GetMapping("/pageQuery")
    public Mono<Page<MisStockWithStoreCorp>> pageQuery(@RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("size") int size){
        return misStockService.pageQuery(name, PageRequest.of(page,size));
    }

    //增加数据
    @PostMapping("/add")
    public Mono<MisStock> save(@RequestBody MisStock misStock){
        return misStockService.add(misStock);
    }

    //修该数据
    @PutMapping("/{id}")
    public Mono<MisStock>update(@PathVariable Long id,@RequestBody MisStock misStock){
        return misStockService.update(id,misStock);
    }
    // 删除数据
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return misStockService.findById(id)
                .flatMap(s -> misStockService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
