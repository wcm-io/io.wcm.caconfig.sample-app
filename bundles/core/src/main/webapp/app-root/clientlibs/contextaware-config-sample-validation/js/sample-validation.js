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
    email: /^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\.[a-zA-Z]{2,4}$/
  };

  // sample validator that validates email synchronously
  registry.register('io.wcm.caconfig.editor.validator', {
    name: 'email-sync-sample',
    validate: function(value) {
      return pattern.email.test(value)
    }
  });

  // sample validator that validates email asynchronously
  // validator returns a promise with resolved = valid, rejected = invalid
  registry.register('io.wcm.caconfig.editor.validator', {
    name: 'email-async-sample',
    async: true,
    validate: function(value) {
      return new Promise((resolve, reject) => {
        // simulate a bit processing time with timeout
        setTimeout(() => {
          var valid =  pattern.email.test(value)
          if (valid) {
            resolve();
          }
          else {
            reject();
          }
        }, 500);
      });
    }
  });

  // sample validator that executes a HTTP request to check if certain page property names exist in the root context page
  // validator returns a promise with resolved = valid, rejected = invalid
  registry.register('io.wcm.caconfig.editor.validator', {
    name: 'pageprops-async-sample',
    async: true,
    validate: function(value, options) {
      return new Promise((resolve, reject) => {
        var pagePropsUrl = options.contextPath + "/_jcr_content.json";
        $.ajax(pagePropsUrl)
          .done(function(data) {
            // check if there is a page property with the given value as name
            var valid = (data[value]) != undefined;
            if (valid) {
              resolve();
            }
            else {
              reject();
            }
          })
          .fail(function() {
            reject();
          })
        });
    }
  });

})(document, Granite, Granite.$);
