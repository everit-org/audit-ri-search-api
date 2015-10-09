package org.everit.audit.search.api.dto;

public class FieldWithType {

  private final String localizedName;

  private final String name;

  private final EventDataType type;

  /**
   * Constructor with initial parameters.
   *
   * @param name
   *          Name of the field.
   * @param localizedName
   *          The localized name by default locale if exists.
   * @param type
   *          Type of the field.
   */
  public FieldWithType(final String name, final EventDataType type, final String localizedName) {
    super();
    this.name = name;
    this.type = type;
    this.localizedName = localizedName;
  }

  public String getLocalizedName() {
    return localizedName;
  }

  public String getName() {
    return name;
  }

  public EventDataType getType() {
    return type;
  }

}
