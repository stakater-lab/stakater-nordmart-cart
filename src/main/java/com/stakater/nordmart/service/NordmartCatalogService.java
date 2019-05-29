package com.stakater.nordmart.service;

import com.stakater.nordmart.common.IstioHeaders;
import com.stakater.nordmart.common.Utils;
import com.stakater.nordmart.model.Product;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NordmartCatalogService
{
    private static final Logger LOG = LoggerFactory.getLogger(NordmartCatalogService.class);

    @Autowired
    CatalogService catalogService;

    List<Product> products() {
        IstioHeaders istioHeaders = new IstioHeaders(Utils.getCurrentHttpRequest());

        LOG.info("Forwarding request to catalog with headers: " + istioHeaders.toString());
        return catalogService.products(istioHeaders.requestId, istioHeaders.b3TraceId,
            istioHeaders.b3SpanId, istioHeaders.b3ParentSpanId, istioHeaders.b3Sampled, istioHeaders.b3Flags,
            istioHeaders.otSpanId);
    }
}
