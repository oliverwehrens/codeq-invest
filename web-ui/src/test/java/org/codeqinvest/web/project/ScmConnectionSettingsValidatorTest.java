/*
 * Copyright 2013 Felix Müller
 *
 * This file is part of CodeQ Invest.
 *
 * CodeQ Invest is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * CodeQ Invest is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CodeQ Invest.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.codeqinvest.web.project;

import org.codeqinvest.codechanges.scm.ScmConnectionSettings;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.fest.assertions.Assertions.assertThat;

public class ScmConnectionSettingsValidatorTest {

  private ScmConnectionSettingsValidator validator;

  @Before
  public void setUp() {
    validator = new ScmConnectionSettingsValidator();
  }

  @Test
  public void shouldSupportScmConnectionSettingsType() {
    assertThat(validator.supports(ScmConnectionSettings.class)).isTrue();
  }

  @Test
  public void shouldNotSupportOtherTypeThanScmConnectionSettings() {
    assertThat(validator.supports(Object.class)).isFalse();
  }

  @Test
  public void validSettingsShouldResultInEmptyErrorsObject() {
    ScmConnectionSettings settings = new ScmConnectionSettings("scm:svn:http://localhost");
    Errors errors = validateSettings(settings);
    assertThat(errors.hasErrors()).isFalse();
  }

  @Test
  public void typeShouldBeSupported() {
    ScmConnectionSettings settings = new ScmConnectionSettings("scm:svn:http://localhost");
    settings.setType(-1);
    Errors errors = validateSettings(settings);
    assertThat(errors.hasFieldErrors("type")).isTrue();
  }

  @Test
  public void urlShouldBeMandatory() {
    ScmConnectionSettings settings = new ScmConnectionSettings("");
    Errors errors = validateSettings(settings);
    assertThat(errors.hasFieldErrors("url")).isTrue();
  }

  private Errors validateSettings(ScmConnectionSettings settings) {
    Errors errors = new BeanPropertyBindingResult(settings, "settings");
    validator.validate(settings, errors);
    return errors;
  }
}
