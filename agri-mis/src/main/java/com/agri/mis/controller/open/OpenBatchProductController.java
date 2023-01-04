package com.agri.mis.controller.open;
import com.agri.mis.domain.BatchProduct;
import com.agri.mis.service.BatchProductService;
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
// 日志
@Slf4j
// 请求路径
@RequestMapping("/open/batch/product")
public class OpenBatchProductController {

    @Autowired
    private BatchProductService batchProductService;

    // 根据id查询数据
    @GetMapping("/{id}")
    public Mono<ResponseEntity<BatchProduct>> find (@PathVariable Long id){
        return batchProductService.findById(id).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // 分页查询数据
     @GetMapping("/pageQuery")
     public Mono<Page<BatchProduct>>pageQuery(@RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("size") int size){
        return batchProductService.pageQuery(name, PageRequest.of(page,size));
     }


    //添加数据
    @PostMapping("/add")
    public Mono<BatchProduct> save(@RequestBody BatchProduct batchProduct){
        return batchProductService.add(batchProduct);
    }

    // 修改数据
    @PutMapping("/{id}")
    public Mono<BatchProduct>update(@PathVariable Long id,@RequestBody BatchProduct batchProduct){
        return batchProductService.update(id,batchProduct);
    }

    // 根据Id删除数据
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id){
        return batchProductService.findById(id).flatMap(
                s -> batchProductService.delete(s)
        ).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
