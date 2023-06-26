/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.data.pipeline.common.datanode;

import org.apache.shardingsphere.infra.datanode.DataNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class DataNodeUtilsTest {
    
    @Test
    void assertFormatWithSchema() {
        DataNode dataNode = new DataNode("ds_0.tbl_0");
        dataNode.setSchemaName("public");
        assertThat(DataNodeUtils.formatWithSchema(dataNode), is("ds_0.public.tbl_0"));
    }
    
    @Test
    void assertParseWithSchema() {
        DataNode actual = DataNodeUtils.parseWithSchema("ds_0.public.tbl_0");
        assertThat(actual.getDataSourceName(), is("ds_0"));
        assertThat(actual.getSchemaName(), is("public"));
        assertThat(actual.getTableName(), is("tbl_0"));
    }
}