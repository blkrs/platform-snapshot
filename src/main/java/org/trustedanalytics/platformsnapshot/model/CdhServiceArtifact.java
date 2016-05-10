/**
 * Copyright (c) 2015 Intel Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.trustedanalytics.platformsnapshot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.trustedanalytics.platformsnapshot.client.cdh.entity.CdhService;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Table(name = "CDH_SERVICE_ARTIFACT")
@NoArgsConstructor
@Entity
public class CdhServiceArtifact {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "snapshot_id")
    @JsonIgnore
    private PlatformSnapshot snapshot;
    private String name;
    private String type;
    private String serviceState;
    private String healthSummary;
    private String entityStatus;

    public CdhServiceArtifact(CdhService cdhService) {
        this.name = cdhService.getName();
        this.type = cdhService.getType();
        this.serviceState = cdhService.getServiceState();
        this.healthSummary = cdhService.getHealthSummary();
        this.entityStatus = cdhService.getEntityStatus();
    }
}
