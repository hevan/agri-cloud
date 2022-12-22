package com.agri.mis.controller.open;



import com.agri.mis.domain.MisStore;
import com.agri.mis.domain.MisStoreItem;
import com.agri.mis.dto.MisStoreItemWithProductStoreCorp;
import com.agri.mis.dto.MisStoreWithAddressCorp;
import com.agri.mis.service.MisStoreItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

// 控制类
@RestController
// 日志打印
@Slf4j
// 路径请求
@RequestMapping("/open/mis/store/item")
public class OpenMisStoreItemController {

    @Autowired
    private MisStoreItemService misStoreItemService;

    // 根据Id查询数据
    @GetMapping("/{id}")
    public Mono<ResponseEntity<MisStoreItem>> findById(@PathVariable Long id){
        return misStoreItemService.findById(id).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // 分页查询
     @GetMapping("/pageQuery")
     public Mono<Page<MisStoreItemWithProductStoreCorp>>pageQuery(@RequestParam("price") BigDecimal price, @RequestParam("page") int page, @RequestParam("size") int size){
        return misStoreItemService.pageQuery(price, PageRequest.of(page,size));
     }

    //增加数据
    @PostMapping("/add")
    public Mono<MisStoreItem>save(@RequestBody MisStoreItem misStoreItem){
        return misStoreItemService.save(misStoreItem);

    }

    // 根据id查询后修改数据
    @PutMapping("/{id}")
    public Mono<MisStoreItem>update(@PathVariable Long id,@RequestBody MisStoreItem misStoreItem){
        return misStoreItemService.update(id,misStoreItem);

    }

    //根据id删除数据
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id){
        return misStoreItemService.findById(id).
                flatMap(s ->misStoreItemService.delete(s)).
                then(Mono.just(new ResponseEntity<>(HttpStatus.NOT_FOUND)));
    }
}
