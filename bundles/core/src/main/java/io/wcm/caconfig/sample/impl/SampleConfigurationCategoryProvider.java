/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2022 wcm.io
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

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.caconfig.spi.metadata.ConfigurationMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.osgi.service.component.annotations.Component;

import io.wcm.caconfig.editor.ConfigurationCategory;
import io.wcm.caconfig.editor.ConfigurationCategoryProvider;

/**
 * Sample {@link ConfigurationCategoryProvider}
 */
@Component(service = ConfigurationCategoryProvider.class)
public class SampleConfigurationCategoryProvider implements ConfigurationCategoryProvider {

  @Override
  public @Nullable ConfigurationCategory getCategoryMetadata(@NotNull String category) {
    return new ConfigurationCategory(category).label(StringUtils.capitalize(category));
  }

  @Override
  public @Nullable String getCategory(@NotNull ConfigurationMetadata configurationMetadata) {
    // default category name for all configurations without a category
    return "default";
  }

}
