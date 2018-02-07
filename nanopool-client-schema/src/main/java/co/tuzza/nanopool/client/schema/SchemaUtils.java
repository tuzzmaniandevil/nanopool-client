/*
 * Copyright 2018 dylan.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package co.tuzza.nanopool.client.schema;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 *
 * @author dylan
 */
public class SchemaUtils {

    private static final ObjectWriter WRITER = new ObjectMapper().writer(new DefaultPrettyPrinter());

    public static String writeToString(BaseNanopoolSchema o) {
        try {
            return WRITER.writeValueAsString(o);
        } catch (JsonProcessingException ex) {
            return o.getClass().getName() + "@" + Integer.toHexString(o.hashCode());
        }
    }
;
}
