/**
 * This file is part of Everit - Audit Search API.
 *
 * Everit - Audit Search API is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Everit - Audit Search API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Everit - Audit Search API.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.osgi.audit.search.api.dto;

import java.util.Objects;

import org.everit.osgi.audit.dto.EventData;

public class EventDataFilter {

    private final Operator operator;

    private final EventData operands;

    /**
     * Constructs a {@code EventDataFilter} with {@link Operator#EQ equivalence operator}.
     *
     * @param operand
     *            the operand of this filter
     */
    public EventDataFilter(final EventData operand) {
        this(Operator.EQ, operand);
    }

    public EventDataFilter(final Operator operator, final EventData operands) {
        this.operator = Objects.requireNonNull(operator, "operator cannot be null");
        this.operands = Objects.requireNonNull(operands, "operand cannot be null");
    }

    public EventData getOperands() {
        return operands;
    }

    public Operator getOperator() {
        return operator;
    }

}
