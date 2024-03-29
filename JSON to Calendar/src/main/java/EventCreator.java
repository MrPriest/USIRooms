import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.client.util.DateTime;

import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class EventCreator {

  /** global variables */

  public static Event createEvent(DateTime update, DateTime start, DateTime end, String idEvent, String nameEvent, String description, String idOrganizer, String nameOrganizer, String emailOrganizer, String idRoom, String nameRoom, String floor){

      Event event = new Event()

      // Event id, name and description
      .setSummary(idEvent + "_" + nameEvent)
      .setDescription(description)

      // Room id, name and floor
      .setLocation(idRoom + "_" + nameRoom + "_" + floor)

      // Event update, begin, end
      .setUpdated(update);
      EventDateTime begin = new EventDateTime()
          .setDateTime(start)
          .setTimeZone("Europe/Zurich");
      event.setStart(begin);
      EventDateTime ending = new EventDateTime()
          .setDateTime(end)
          .setTimeZone("Europe/Zurich");
      event.setEnd(ending);

      // Organizer id, name and emails
      Event.Organizer organizer = new Event.Organizer()
          .setId(idOrganizer)
          .setDisplayName(nameOrganizer)
          .setEmail(emailOrganizer);
      event.setOrganizer(organizer);

      return event;

  }
}
