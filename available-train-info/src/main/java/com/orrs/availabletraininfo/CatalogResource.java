package com.orrs.availabletraininfo;

import com.orrs.availabletraininfo.details.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping ("/catalog")
public class CatalogResource {

    @RequestMapping ("{trainId}")

    public List<CatalogItem> getCatalog(@PathVariable ("trainId") String trainId) {
        return Collections.singletonList(
                new CatalogItem( "Rajdhani", 1001)
        );
    }
}
