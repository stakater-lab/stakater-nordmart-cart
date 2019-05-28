package com.stakater.nordmart.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stakater.nordmart.model.Product;

@FeignClient(name = "catalogService", url = "${catalog.endpoint}")
interface CatalogService {

	@RequestMapping(method = RequestMethod.GET, value = "/api/products")
    List<Product> products(@RequestHeader("x-request-id") String requestId,
                           @RequestHeader("x-b3-traceid") String b3TraceId,
                           @RequestHeader("x-b3-spanid") String b3SpanId,
                           @RequestHeader("x-b3-parentspanid") String b3ParentSpanId,
                           @RequestHeader("x-b3-sampled") String b3Sampled,
                           @RequestHeader("x-b3-flags") String b3Flags,
                           @RequestHeader("x-ot-span-context") String otSpanId);
}