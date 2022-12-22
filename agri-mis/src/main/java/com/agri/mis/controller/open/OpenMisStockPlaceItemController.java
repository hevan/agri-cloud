package com.agri.mis.controller.open;

import com.agri.mis.domain.MisStockPlaceItem;
import com.agri.mis.dto.MisStockPlaceItemWithStockPlaceProduct;
import com.agri.mis.service.MisStockPlaceItemService;

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
@RequestMapping("/open/mis/stock/place/item")
public class OpenMisStockPlaceItemController {
    @Autowired
    private MisStockPlaceItemService misStockPlaceItemService;

    // 根据id查询数据
    @GetMapping("/{id}")
    public Mono<ResponseEntity<MisStockPlaceItem>> findById(@PathVariable Long id){
        return misStockPlaceItemService.findById(id).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

       // 分页查询数据
    @GetMapping("/pageQuery")
    public Mono<Page<MisStockPlaceItemWithStockPlaceProduct>> pageQuery(@RequestParam("boxCode") String boxCode, @RequestParam("page") int page, @RequestParam("size") int size){
        return misStockPlaceItemService.pageQuery(boxCode, PageRequest.of(page,size));
    }

    // 添加数据
    @PostMapping("/add")
    public Mono<MisStockPlaceItem> save(@RequestBody MisStockPlaceItem misStockPlaceItem){
        return misStockPlaceItemService.save(misStockPlaceItem);
    }

    // 根据id修该数据内容
    @PutMapping("{id}")
    public Mono<MisStockPlaceItem>update(@PathVariable Long id,@RequestBody MisStockPlaceItem misStockPlaceItem){
    return misStockPlaceItemService.update(id,misStockPlaceItem);
    }

    // 根据id删除数据
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>>delete(@PathVariable Long id){
    return misStockPlaceItemService.findById(id)
            .flatMap(s ->misStockPlaceItemService.delete(s)
                    .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
            .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
