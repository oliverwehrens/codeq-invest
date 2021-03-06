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
package org.codeqinvest.sonar;

import lombok.Data;

/**
 * @author fmueller
 */
@Data
public class ProjectInformation implements Comparable {

  private String name;
  private String resourceKey;

  public ProjectInformation() {
    this("", "");
  }

  public ProjectInformation(String name, String resourceKey) {
    this.name = name;
    this.resourceKey = resourceKey;
  }

    @Override
    public int compareTo(Object o) {
      if (o != null) {
        ProjectInformation otherProjectInformation = (ProjectInformation) o;
          if (otherProjectInformation.getName() != null && this.getName() != null) {
            return this.name.compareToIgnoreCase(otherProjectInformation.getName());
          }
      }
      return 1;
    }
}
