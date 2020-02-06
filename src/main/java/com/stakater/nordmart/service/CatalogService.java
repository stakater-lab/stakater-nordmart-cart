package com.stakater.nordmart.service;

import com.stakater.nordmart.model.Product;
import feign.HeaderMap;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@FeignClient(name = "catalogService", url = "${catalog.endpoint}")
interface CatalogService
{

    @RequestMapping(method = RequestMethod.GET, value = "/api/products")
    List<Product> products(@HeaderMap Map headers);
}