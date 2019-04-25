/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.optaweb.vehiclerouting.service.demo;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.optaweb.vehiclerouting.service.demo.dataset.DataSet;
import org.springframework.stereotype.Component;

@Component
public class DataSetReader {

    private final ObjectMapper mapper;

    public DataSetReader() {
        mapper = new ObjectMapper(new YAMLFactory());
    }

    public DataSetReader(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    DataSet demoDataSet() {
        try (InputStream inputStream = DataSetReader.class.getResourceAsStream("belgium-cities.yaml")) {
            return mapper.readValue(inputStream, DataSet.class);
        } catch (IOException e) {
            throw new IllegalStateException("Can't read demo data set.", e);
        }
    }
}
