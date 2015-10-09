package org.everit.audit.search.api;

import java.time.Instant;
import java.util.List;

import org.everit.audit.search.api.dto.EventDataFilter;
import org.everit.audit.search.api.dto.EventUi;
import org.everit.audit.search.api.dto.FieldWithType;

public interface AuditReader {

  List<EventUi> findEvents(long[] selectedAppIds, long[] selectedEventTypeIds,
      List<String> dataFields,
      List<EventDataFilter> eventDataFilters, Instant eventsFrom, Instant eventsTo, long offset,
      long limit);

  /**
   * Find applications by name.
   *
   * @param applicationName
   *          the name of the application to find
   * @return the AuditApplication DTO object that matches the given name or <code>null</code> if not
   *         found
   * @throws NullPointerException
   *           if {@code applicationName} is <code>null</code>
   */
  AuditApplication getApplication(String applicationName);

  /**
   * Get all applications.
   *
   * @return the List of applications
   */
  List<AuditApplication> getApplications();

  AuditEventType getAuditEventType(String eventTypeName);

  AuditEventType getAuditEventType(String applicationName, String eventTypeName);

  List<AuditEventType> getAuditEventTypes();

  List<AuditEventType> getAuditEventTypes(String applicationName);

  /**
   * Read a single event.
   *
   * @param eventId
   *          The id of the event to be read.
   * @param dataFields
   *          the fields for the event to be read, in case of <code>null</code> all fields will be
   *          returned.
   * @return The eventUi dto.
   */
  EventUi getEventById(long eventId, String... dataFields);

  /**
   * Gets the result according to application and eventType parameters.
   *
   * @param applicationIds
   *          The applicationIds.
   * @param eventTypeIds
   *          The eventTypeIds.
   * @return the list of EventData related to the selected apps and events to be shown on the result
   *         screen to be able to show the fields with datatypes for UI filter.
   */
  List<FieldWithType> getResultFieldsWithTypes(long[] applicationIds, Long[] eventTypeIds);

}
