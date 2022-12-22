package com.agri.mis.controller.open;



import com.agri.mis.domain.MisStockPlace;
import com.agri.mis.dto.MisStockPlaceWithProductStoreStockCrop;
import com.agri.mis.service.MisStockPlaceService;
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
@RequestMapping("/open/mis/stock/place")
public class OpenMisStockPlaceController {
    @Autowired
    private MisStockPlaceService misStockPlaceService;


    // 根据id查询数据
    @GetMapping("/{id}")
    public Mono<ResponseEntity<MisStockPlace>> findById(@PathVariable Long id){
        return misStockPlaceService.findById(id).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    // 分页查询
    @GetMapping("/pageQuery")
    public Mono<Page<MisStockPlaceWithProductStoreStockCrop>>pagequery(@RequestParam("status") String status, @RequestParam("page") int page, @RequestParam("size") int size){
        return misStockPlaceService.pageQuery(status,PageRequest.of(page,size));
    }
        


    // 增加数据
    @PostMapping("/add")
    public Mono<MisStockPlace> save(@RequestBody MisStockPlace misStockPlace){
        return misStockPlaceService.save(misStockPlace);
    }

    //根据id修改数据
    @PutMapping("{id}")
    public Mono<MisStockPlace>update(@PathVariable Long id,@RequestBody MisStockPlace misStockPlace){
        return misStockPlaceService.update(id,misStockPlace);
    }

    // 根据id删除数据
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id){
        return misStockPlaceService.findById(id).flatMap(s -> misStockPlaceService.delete(s).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}

