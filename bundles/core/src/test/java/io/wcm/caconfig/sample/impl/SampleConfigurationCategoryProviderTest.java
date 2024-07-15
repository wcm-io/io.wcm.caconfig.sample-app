/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2024 wcm.io
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
package io.wcm.caconfig.sample.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collections;

import org.apache.sling.caconfig.spi.metadata.ConfigurationMetadata;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.caconfig.editor.ConfigurationCategory;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
class SampleConfigurationCategoryProviderTest {

  private final AemContext context = new AemContext();

  private SampleConfigurationCategoryProvider underTest;

  @BeforeEach
  void setUp() {
    underTest = context.registerInjectActivateService(SampleConfigurationCategoryProvider.class);
  }

  @Test
  void testGetCategoryMetadata() {
    ConfigurationCategory category = underTest.getCategoryMetadata("test");
    assertNotNull(category);
    assertEquals("test", category.getCategory());
    assertEquals("Test", category.getLabel());
  }

  @Test
  void testGetCategory() {
    ConfigurationMetadata metadata = new ConfigurationMetadata("test", Collections.emptyList(), false);
    assertEquals("default", underTest.getCategory(metadata));
  }

}
