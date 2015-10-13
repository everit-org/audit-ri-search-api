package org.everit.audit.search.api.dto;

import java.util.Objects;

import org.everit.audit.dto.EventData;

public class EventDataFilter {

  private final EventData operands;

  private final Operator operator;

  /**
   * Constructs a {@code EventDataFilter} with {@link Operator#EQ equivalence operator}.
   *
   * @param operand
   *          the operand of this filter
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
