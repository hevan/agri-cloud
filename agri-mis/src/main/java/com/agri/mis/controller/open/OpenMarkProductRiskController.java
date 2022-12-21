package com.agri.mis.controller.open;

import com.agri.mis.domain.MarkProductRisk;
import com.agri.mis.dto.MarkProductMarketWithProductWithMarket;
import com.agri.mis.dto.MarkProductRiskWithMarkProductBatch;
import com.agri.mis.service.MarkProductRiskService;
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
@RequestMapping("/open/mark/product/risk")
public class OpenMarkProductRiskController {

    @Autowired
    private MarkProductRiskService markProductRiskService;

    // 根据id查询数据
    @GetMapping("/{id}")
    public Mono<ResponseEntity<MarkProductRisk>> findById(@PathVariable Long id){
        return markProductRiskService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    //增加数据
    @PostMapping("/add")
    public Mono<MarkProductRisk> save(@RequestBody MarkProductRisk markProductRisk){
        return markProductRiskService.add(markProductRisk);
    }

    //修该数据
    @PutMapping("/{id}")
    public Mono<MarkProductRisk>update(@PathVariable Long id,@RequestBody MarkProductRisk markProductRisk){
        return markProductRiskService.update(id,markProductRisk);
    }
    // 删除数据
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return markProductRiskService.findById(id)
                .flatMap(s -> markProductRiskService.delexte(s)
                        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/pageQuery")
    public Mono<Page<MarkProductRiskWithMarkProductBatch>> pageQuery(@RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("size") int size){
        return markProductRiskService.pageQuery(name, PageRequest.of(page,size));
    }

}
