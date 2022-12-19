package com.agri.mis.controller.open;

import com.agri.mis.domain.MisStockItem;
import com.agri.mis.dto.MisStockItemWithProductStoreStockCorp;
import com.agri.mis.service.MisStockItemService;
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
@RequestMapping("/open/mis/stock/item")
public class OpenMisStockItemController {

    @Autowired
    private MisStockItemService misStockItemService;

    // 根据id查询数据
    @GetMapping("/{id}")
    public Mono<ResponseEntity<MisStockItem>>findById(@PathVariable Long id){
        return misStockItemService.findById(id).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

     //分页查询
  @GetMapping("/pageQuery")
   public Mono<Page<MisStockItemWithProductStoreStockCorp>> pagequery(@RequestParam("price") BigDecimal price, @RequestParam("page") int page, @RequestParam("size") int size){

    return misStockItemService.pageQuery(price, PageRequest.of(page,size));
}


    // 增加数据
    @PostMapping("/add")
    public Mono<MisStockItem> save(@RequestBody MisStockItem misStockItem){
        return misStockItemService.add(misStockItem);
    }
    //根据id修改数据
    @PutMapping("/{id}")
    public Mono<MisStockItem>update(@PathVariable Long id,@RequestBody MisStockItem misStockItem){
        return misStockItemService.update(id,misStockItem);
    }
    // 根据ID删除数据
    @DeleteMapping("{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id){
        return misStockItemService.findById(id)
                .flatMap(s -> misStockItemService.delete(s)
                        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
