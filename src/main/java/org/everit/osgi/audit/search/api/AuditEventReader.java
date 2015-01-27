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
package org.everit.osgi.audit.search.api;

import java.time.Instant;
import java.util.List;

import org.everit.osgi.audit.search.api.dto.EventDataFilter;
import org.everit.osgi.audit.search.api.dto.EventUi;
import org.everit.osgi.audit.search.api.dto.FieldWithType;

public interface AuditEventReader {

    List<EventUi> findEvents(long[] selectedAppIds, long[] selectedEventTypeIds, List<String> dataFields,
            List<EventDataFilter> eventDataFilters, Instant eventsFrom, Instant eventsTo, long offset, long limit);

    /**
     * Read a single event.
     *
     * @param eventId
     *            The id of the event to be read.
     * @param dataFields
     *            the fields for the event to be read, in case of <code>null</code> all fields will be returned.
     * @return The eventUi dto.
     */
    EventUi getEventById(long eventId, String... dataFields);

    /**
     * Gets the result according to application and eventType parameters.
     *
     * @param applicationIds
     *            The applicationIds.
     * @param eventTypeIds
     *            The eventTypeIds.
     * @return the list of EventData related to the selected apps and events to be shown on the result screen to be able
     *         to show the fields with datatypes for UI filter.
     */
    List<FieldWithType> getResultFieldsWithTypes(long[] applicationIds, Long[] eventTypeIds);

}
