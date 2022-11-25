/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2021 wcm.io
 * %%
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
 * #L%
 */
package io.wcm.caconfig.sample.config;

import static io.wcm.caconfig.editor.EditorProperties.PROPERTY_CATEGORY;

import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;

/**
 * Config annotation class example to test overrides.
 */
@Configuration(label = "Override Sample Configuration",
    description = "This is a sample configuration for testing overrides.",
    property = {
        PROPERTY_CATEGORY + "=override"
    })
public @interface ConfigOverrideSample {

  /**
   * @return String parameter
   */
  @Property(label = "String Param", description = "This is a string parameter in the singleton configuration.", order = 1)
  String stringParam();

  /**
   * @return Integer parameter
   */
  @Property(label = "Integer Param", order = 2)
  int intParam();

}
