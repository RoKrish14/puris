package org.eclipse.tractusx.puris.backend.stock.masterdata.logic;

import org.eclipse.tractusx.puris.backend.masterdata.domain.model.Partner;
import org.eclipse.tractusx.puris.backend.masterdata.domain.repository.PartnerRepository;
import org.eclipse.tractusx.puris.backend.masterdata.logic.service.PartnerServiceImpl;
import org.eclipse.tractusx.puris.backend.stock.domain.model.ItemStock;
import org.eclipse.tractusx.puris.backend.stock.domain.model.measurement.MeasurementUnit;
import org.eclipse.tractusx.puris.backend.stock.domain.repository.ItemStockRepository;
import org.eclipse.tractusx.puris.backend.stock.logic.service.ItemStockService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ItemStockServiceTest {

    @Mock
    private ItemStockRepository itemStockRepository;
    @Mock
    private PartnerRepository partnerRepository;
    @InjectMocks
    private PartnerServiceImpl partnerService;
    @InjectMocks
    private ItemStockService itemStockService;
    private final String semiconductorMatNbrCustomer = "MNR-7307-AU340474.002";
    private final String semiconductorMatNbrSupplier = "MNR-8101-ID146955.001";

    @Test
    void storeAndFindItemStock() {
        Partner supplierPartner = createAndGetSupplierPartner();
        ItemStock.Builder builder = ItemStock.Builder.newInstance();
        var itemStock = builder
            .customerOrderId("123")
            .supplierOrderId("234")
            .customerOrderPositionId("1")
            .direction(ItemStock.Direction.INBOUND)
            .materialNumberCustomer(semiconductorMatNbrCustomer)
            .materialNumberSupplier(semiconductorMatNbrSupplier)
            .measurementUnit(MeasurementUnit.piece)
            .locationBpns(supplierPartner.getSites().first().getBpns())
            .locationBpna(supplierPartner.getSites().first().getAddresses().first().getBpna())
            .partnerBpnl(supplierPartner.getBpnl())
            .quantity(5)
            .build();

//        when(partnerRepository.)

        itemStock = itemStockService.create(itemStock);
        var foundItemStock = itemStockService.findAll().get(0);
        Assertions.assertEquals(itemStock, foundItemStock);

    }

    private Partner createAndGetSupplierPartner() {
        Partner supplierPartnerEntity = new Partner(
            "Scenario Supplier",
            "http://supplier-control-plane:9184/api/v1/dsp",
            "BPNL1234567890ZZ",
            "BPNS1234567890ZZ",
            "Konzernzentrale Dudelsdorf",
            "BPNA1234567890AA",
            "Heinrich-Supplier-Straße 1",
            "77785 Dudelsdorf",
            "Germany"
        );
        supplierPartnerEntity = partnerService.create(supplierPartnerEntity);
        supplierPartnerEntity = partnerService.findByUuid(supplierPartnerEntity.getUuid());
        return supplierPartnerEntity;
    }
}
