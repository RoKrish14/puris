# Architecture Constraints

PURIS FOSS follows the following constraints:

| Constraint                                 | Background or motivation                                                                                                                                                                                                                                                                                                                                 |
|--------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| IDS & GAIA-X Compliance                    | Data sharing, storing and processing must be in compliance to the standards provided by GAIA-X and IDS.                                                                                                                                                                                                                                                  |
| Data Sharing between Companies             | Companies must use IDS compliant and certified connectors along with an approved Catena-X information model for communication. This guarantees interoperability between certified participants. The Eclipse Dataspace Connector is highly recommended for this purpose. The data should stay inside the connector if full data sovereignty is necessary. |
| Data sovereignty                           | To ensure data sovereignty, data owners need to attach machine readable access policies and contract policies to their data before sharing. The data consumer has to accept the usage policies before processing the data. Connectors (+ the underlying / corresponding systems) must technically enforce those usage policy descriptions.               |
| Managed Identity Wallet (MIW)              | MIW is a central Catena-X Service, which allows storing credentials to prove claims in the Catena-X data space.                                                                                                                                                                                                                                          |
| Interoperability between Data Applications | Data exchange MUST follow standards so that different vendors applications may exchange data. This allows to reduce the risk of vendor-lock-ins.                                                                                                                                                                                                         |
| Semantic Aspect Meta Model (SAMM)          | Tooling used in Catena-X to semantically describe data.                                                                                                                                                                                                                                                                                                  |
| Digital Twins in Catena-X & Industry Core  | Standards CX-0002 and CX-0126 describe how Digital Twins following with the Asset Administration Shell shall be used. PURIS standards are built on these foundations.                                                                                                                                                                                    |

## NOTICE

This work is licensed under the [Apache-2.0](https://www.apache.org/licenses/LICENSE-2.0).

- SPDX-License-Identifier: Apache-2.0
- SPDX-FileCopyrightText: 2024 Contributors to the Eclipse Foundation
- Source URL: https://github.com/eclipse-tractusx/puris
