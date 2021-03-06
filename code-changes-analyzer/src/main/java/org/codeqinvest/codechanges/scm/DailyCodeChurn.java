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
package org.codeqinvest.codechanges.scm;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.joda.time.LocalDate;

import java.util.List;

/**
 * Encapsulates al code churn proportions of one day.
 *
 * @author fmueller
 */
@Getter
@EqualsAndHashCode
@ToString
public class DailyCodeChurn extends CodeChurn {

  private final LocalDate day;

  public DailyCodeChurn(LocalDate day, List<Double> codeChurnProportions) {
    super(codeChurnProportions);
    this.day = day;
  }
}
