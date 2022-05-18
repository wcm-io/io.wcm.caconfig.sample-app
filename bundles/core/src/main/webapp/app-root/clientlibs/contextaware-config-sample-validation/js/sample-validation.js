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
/*
 * Example for custom asynchronous validation in Context-Aware Configuration Editor.
 */
;(function(document, Granite, $) {
  "use strict";

  var registry = $(window).adaptTo("foundation-registry");

  // Predefined patterns
  var pattern = {
    email: /^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\.[a-zA-Z]{2,4}$/,
    onlyX: /^x+$/
  };

  // sample validator that validates email synchronously
  registry.register('io.wcm.caconfig.editor.validator', {
    name: 'email-sync-sample',
    validate: function(value) {
      return pattern.email.test(value)
    }
  });

  // sample validator that validates email asynchronously
  registry.register('io.wcm.caconfig.editor.validator', {
    name: 'email-async-sample',
    async: true,
    validate: function(value) {
      return new Promise((resolve, reject) => {
        // simulate a bit processing time with timeout
        setTimeout(() => {
          if (pattern.onlyX.test(value)) {
            // simulate reject when value only consits of "x" characters
            reject();
            return;
          }
          var valid =  pattern.email.test(value)
          resolve(valid);
        }, 300);
      });
    }
  });

  // sample validator that executes a HTTP request to check if certain page property names exist in the root context page
  registry.register('io.wcm.caconfig.editor.validator', {
    name: 'http-request-pageprops-sample',
    validate: function(value, options) {
    }
  });

})(document, Granite, Granite.$);
