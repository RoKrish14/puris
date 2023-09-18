/*
 * Copyright (c) 2023 Volkswagen AG
 * Copyright (c) 2023 Fraunhofer-Gesellschaft zur Foerderung der angewandten Forschung e.V.
 * (represented by Fraunhofer ISST)
 * Copyright (c) 2023 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.eclipse.tractusx.puris.backend.stock.logic.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.eclipse.tractusx.puris.backend.masterdata.logic.dto.MaterialDto;
import org.eclipse.tractusx.puris.backend.masterdata.logic.dto.PartnerDto;
import org.eclipse.tractusx.puris.backend.stock.domain.model.datatype.DT_StockTypeEnum;
import org.eclipse.tractusx.puris.backend.stock.domain.model.measurement.MeasurementUnit;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class ProductStockDto extends StockDto {

    private PartnerDto allocatedToCustomerPartner;

    public ProductStockDto(MaterialDto material, double quantity, MeasurementUnit measurementUnit, String atSiteBpns) {
        super(material, quantity, measurementUnit, atSiteBpns, new Date());
        this.setType(DT_StockTypeEnum.PRODUCT);
    }

    public ProductStockDto(MaterialDto material, double quantity, MeasurementUnit measurementUnit, String atSiteBpns,
                           PartnerDto allocatedToCustomerPartner) {
        super(material, quantity, measurementUnit, atSiteBpns, new Date());
        this.setType(DT_StockTypeEnum.PRODUCT);
        this.allocatedToCustomerPartner = allocatedToCustomerPartner;
    }
}
