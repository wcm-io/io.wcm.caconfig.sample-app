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
package io.wcm.caconfig.sample.config;

import static io.wcm.caconfig.editor.EditorProperties.PROPERTY_REQUIRED;
import static io.wcm.caconfig.editor.EditorProperties.PROPERTY_VALIDATION;
import static io.wcm.caconfig.editor.EditorProperties.PROPERTY_VALIDATION_MESSAGE;
import static io.wcm.caconfig.editor.EditorProperties.PROPERTY_WIDGET_TYPE;
import static io.wcm.caconfig.editor.EditorProperties.WIDGET_TYPE_TEXTAREA;

import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;

/**
 * Sample configuration with custom validations.
 */
@Configuration(label = "Sample Configuration with Validation", description = "Sample configuration with custom validations.")
public @interface ValidationSample {

  /**
   * @return String parameter
   */
  @Property(label = "String Param", description = "This is a mandatory string parameter in the singleton configuration.", order = 5,
      property = {
          PROPERTY_REQUIRED + "=true"
      })
  String stringParam();

  /**
   * @return E-Mail synchronous validation
   */
  @Property(label = "E-Mail (sync)", description = "E-Mail synchronous validation.", order = 10, property = {
      PROPERTY_VALIDATION + "=email-sync-sample",
      PROPERTY_VALIDATION_MESSAGE + "=Please enter a valid email address.",
      PROPERTY_REQUIRED + "=true"
  })
  String emailParam();

  /**
   * @return E-Mail asynchronous validation
   */
  @Property(label = "E-Mail (async)", description = "E-Mail asynchronous validation.", order = 11, property = {
      PROPERTY_VALIDATION + "=email-async-sample",
      PROPERTY_VALIDATION_MESSAGE + "=Please enter a valid email address."
  })
  String emailParamAsync();

  /**
   * @return E-Mail synchronous validation with GraniteUI foundation validator.
   */
  @Property(label = "E-Mail (sync, Granite)", description = "E-Mail synchronous validation using GraniteUI foundation validator.", order = 12, property = {
      PROPERTY_VALIDATION + "=wcmio.email",
      PROPERTY_VALIDATION_MESSAGE + "=Please enter a valid email address."
  })
  String emailParamGraniteFoundation();

  /**
   * @return E-Mail synchronous validation
   */
  @Property(label = "Page Property Name (async)",
      description = "String parameter that is valid when it matched with a page properties name from the context root page (e.g. 'pageTitle').",
      order = 20, property = {
          PROPERTY_VALIDATION + "=pageprops-async-sample",
          PROPERTY_VALIDATION_MESSAGE + "=This is not a valid page properties name from the context root page."
      })
  String pagePropertyName();

  /**
   * @return Number 0..10
   */
  @Property(label = "Number 0..10 (sync)", description = "Number with validation between 0 and 10.", order = 30, property = {
      PROPERTY_VALIDATION + "=number-0-10-sample",
      PROPERTY_VALIDATION_MESSAGE + "=Please enter a number between 0 and 10."
  })
  int numberParam();

  /**
   * @return E-Mail synchronous validation (array)
   */
  @Property(label = "E-Mail Array (sync)", description = "E-Mail synchronous validation.", order = 40, property = {
      PROPERTY_VALIDATION + "=email-sync-sample",
      PROPERTY_VALIDATION_MESSAGE + "=Please enter a valid email address."
  })
  String[] emailArray();

  /**
   * @return Number 0..10 Array
   */
  @Property(label = "Number 0..10 Array (sync)", description = "Number with validation between 0 and 10.", order = 41, property = {
      PROPERTY_VALIDATION + "=number-0-10-sample",
      PROPERTY_VALIDATION_MESSAGE + "=Please enter a number between 0 and 10."
  })
  int[] numberArray();

  /**
   * @return Path parameter
   */
  @Property(label = "String Text Area", description = "Enter multiple lines of text.", order = 100,
      property = {
          PROPERTY_WIDGET_TYPE + "=" + WIDGET_TYPE_TEXTAREA,
          PROPERTY_VALIDATION + "=email-sync-sample",
          PROPERTY_VALIDATION_MESSAGE + "=Please enter a valid email address."
      })
  String stringTextArea();

}
