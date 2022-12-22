package com.agri.mis.controller.open;

import com.agri.mis.domain.MisStockPlace;
import com.agri.mis.domain.MisStockPlaceItemSub;
import com.agri.mis.dto.MisStockPlaceItemSubWithStockPlaceItem;
import com.agri.mis.service.MisStockPlaceItemSubService;
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
@RequestMapping("/open/mis/stock/place/item/sub")
public class OpenMisStockPlaceItemSubController {

    @Autowired
    private MisStockPlaceItemSubService misStockPlaceItemSubService;

    // 根据id查询数据
    @GetMapping("/{id}")
    public Mono<ResponseEntity<MisStockPlaceItemSub>>findById(@PathVariable Long id){
        return misStockPlaceItemSubService.findById(id).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // 分页查询数据  quantity
    @GetMapping("/pageQuery")
    public Mono<Page<MisStockPlaceItemSubWithStockPlaceItem>> pageQuery(@RequestParam("orginCode") String orginCode, @RequestParam("page") int page, @RequestParam("size") int size){
         return misStockPlaceItemSubService.pageQuery(orginCode, PageRequest.of(page,size));
    }

    // 添加数据
    @PostMapping("/add")
    public Mono<MisStockPlaceItemSub>save(@RequestBody MisStockPlaceItemSub misStockPlaceItemSub){
        return misStockPlaceItemSubService.save(misStockPlaceItemSub);
    }

    // 根据id修该数据内容
    @PutMapping("{id}")
    public Mono<MisStockPlaceItemSub>update(@PathVariable Long id,@RequestBody MisStockPlaceItemSub misStockPlaceItemSub){
        return misStockPlaceItemSubService.update(id,misStockPlaceItemSub);
    }

    // 根据Id删除数据
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>>delete(@PathVariable Long id){
        return misStockPlaceItemSubService.findById(id)
                .flatMap(s ->misStockPlaceItemSubService.delete(s)
                        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
