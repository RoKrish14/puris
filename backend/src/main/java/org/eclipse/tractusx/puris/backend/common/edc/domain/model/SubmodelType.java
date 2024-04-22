/*
 * Copyright (c) 2024 Volkswagen AG
 * Copyright (c) 2024 Contributors to the Eclipse Foundation
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

package org.eclipse.tractusx.puris.backend.common.edc.domain.model;

public enum SubmodelType {
    DTR("none", "none"),
    ITEM_STOCK("urn:samm:io.catenax.item_stock:2.0.0#ItemStock", "$value"),
    PART_TYPE_INFORMATION("urn:samm:io.catenax.part_type_information:1.0.0#PartTypeInformation", "$value");

    public final String TYPE_URN;
    public final String REPRESENTATION;

    SubmodelType(String TYPE_URN, String REPRESENTATION) {
        this.TYPE_URN = TYPE_URN;
        this.REPRESENTATION = REPRESENTATION;
    }
}
