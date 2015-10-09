package org.everit.audit.search.api.dto;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EventUi {

  public static class Builder {

    private String appName;

    private final Map<String, EventData> eventData = new HashMap<>();

    private long eventId;

    private Instant saveTimestamp;

    private String typeName;

    public Builder appName(final String appName) {
      this.appName = appName;
      return this;
    }

    public Builder binaryData(final String name, final byte[] data) {
      eventData.put(name, new EventData(name, data));
      return this;
    }

    public EventUi build() {
      return new EventUi(eventId, typeName, appName, saveTimestamp, eventData);
    }

    public Builder eventId(final long eventId) {
      this.eventId = eventId;
      return this;
    }

    public Builder numberData(final String name, final double number) {
      eventData.put(name, new EventData(name, number));
      return this;
    }

    public Builder saveTimestamp(final Instant saveTimestamp) {
      this.saveTimestamp = saveTimestamp;
      return this;
    }

    public Builder stringData(final String name, final String data) {
      eventData.put(name, new EventData(name, data));
      return this;
    }

    public Builder textData(final String name, final String data) {
      eventData.put(name, new EventData(name, false, data));
      return this;
    }

    public Builder timestampData(final String name, final Instant data) {
      eventData.put(name, new EventData(name, data));
      return this;
    }

    public Builder typeName(final String typeName) {
      this.typeName = typeName;
      return this;
    }

  }

  /**
   * The name of the application which the event belongs to.
   */
  private final String applicationName;
  /**
   * Map containing the event data.
   */
  private final Map<String, EventData> eventData;
  /**
   * Id of the event.
   */
  private final long id;
  /**
   * Name of the event.
   */
  private final String name;
  /**
   * TimeStamp when the event was saved.
   */
  private final Instant saveTimeStamp;

  public EventUi(final long id, final String name, final String applicationName,
      final Instant saveTimeStamp,
      final Map<String, EventData> eventData) {
    this.id = id;
    this.name = Objects.requireNonNull(name, "name cannot be null");
    this.applicationName =
        Objects.requireNonNull(applicationName, "applicationName cannot be null");
    this.saveTimeStamp = Objects.requireNonNull(saveTimeStamp, "saveTimeStamp cannot be null");
    this.eventData = Objects.requireNonNull(eventData, "eventData cannot be null");
  }

  public String getApplicationName() {
    return applicationName;
  }

  public Map<String, EventData> getEventData() {
    return eventData;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Instant getSaveTimeStamp() {
    return saveTimeStamp;
  }

}
