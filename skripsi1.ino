#include <FirebaseArduino.h>
#include <ESP8266WiFi.h>
//#include <Firebase.h>

#define FIREBASE_HOST "skripsi1-fe1f1.firebaseio.com" // #isi sesuai database firebase
#define FIREBASE_AUTH "DyOLQuOQlmo8bL7dCYOjTwEmKtoaTrkkze76PbpL" // #isi sesuai database firebase
#define WIFI_SSID "AP Gunt." // #SSID hotspot
#define WIFI_PASSWORD "qwertyassf1" // #Password hotspot

#define Relay1            D1
#define Relay2            D2
#define Relay3            D5
#define Relay4            D6

WiFiClient client;

int kipas = 0, lampu = 0, pompa = 0, termometer = 0;

//int Relay1 = D2;
//int Relay2 = D4;
//int Relay3 = D6;
//int Relay4 = D8;

void setup(){
  Serial.begin(115200);

  pinMode(Relay1, OUTPUT);// menjelaskan relay sebagai output
  pinMode(Relay2, OUTPUT);
  pinMode(Relay3, OUTPUT);
  pinMode(Relay4, OUTPUT);

  delay(500);
  Serial.println('\n');

  wifiConnect();
  
  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH); 

  delay(10);
}

void loop() {

//  KIPAS
  kipas = Firebase.getInt("kipas");
  if(kipas == 0) {
    digitalWrite(Relay1, HIGH);
  } else {
    digitalWrite(Relay1, LOW);
  }

  delay(10);


// Lampu
  lampu = Firebase.getInt("lampu");
  if(lampu == 0) {
    digitalWrite(Relay2, HIGH);
  } else {
    digitalWrite(Relay2, LOW);
  }

  delay(10);


  // POMPA
  pompa = Firebase.getInt("pompa");
  if(pompa == 0) {
    digitalWrite(Relay3, HIGH);
  } else {
    digitalWrite(Relay3, LOW);
  }

  delay(10);


  // Termometer
  termometer = Firebase.getInt("termometer");
  if(termometer == 0) {
    digitalWrite(Relay4, HIGH);
  } else {
    digitalWrite(Relay4, LOW);
  }

  delay(10);

  
  if(WiFi.status() != WL_CONNECTED)
  {
    wifiConnect();
  }
  delay(10);
}

void wifiConnect()
{
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("Connecting to ");
  Serial.print(WIFI_SSID); Serial.println(" ...");

  int teller = 0;
  while (WiFi.status() != WL_CONNECTED)
  {                                       
    delay(1000);
    Serial.print(++teller); Serial.print(' ');
  }

  Serial.println('\n');
  Serial.println("Connection established!");  
  Serial.print("IP address:\t");
  Serial.println(WiFi.localIP()); 
}
