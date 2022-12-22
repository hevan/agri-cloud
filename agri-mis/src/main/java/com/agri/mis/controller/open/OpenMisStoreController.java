package com.agri.mis.controller.open;

import com.agri.mis.domain.MisStore;
import com.agri.mis.dto.MisStoreWithAddressCorp;
import com.agri.mis.service.MisStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

// 控制类
@RestController
// 日志打印
@Slf4j
// 路径请求
@RequestMapping("/open/mis/store")
public class OpenMisStoreController {

    @Autowired
    private MisStoreService misStoreService;

    // 根据id查询数据
    @GetMapping("/{id}")
    public Mono<ResponseEntity<MisStore>> findById(@PathVariable Long id){
        return misStoreService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

      // 分页查询数据
    @GetMapping("/pageQuery")
    public Mono<Page<MisStoreWithAddressCorp>>pageQuery(@RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("size") int size){
    return misStoreService.pageQuery(name, PageRequest.of(page,size));
    }

    //增加数据
    @PostMapping("/add")
    public Mono<MisStore>save(@RequestBody MisStore misStore){
        return misStoreService.save(misStore);
    }

    // 根据id查询后修改数据
    @PutMapping("/{id}")
    public Mono<MisStore>update(@PathVariable Long id,@RequestBody MisStore misStore){
        return misStoreService.update(id,misStore);

    }

    // 根据id删除数据
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id){
        return misStoreService.findById(id).
                flatMap(s ->misStoreService.delete(s))
                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))

        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
