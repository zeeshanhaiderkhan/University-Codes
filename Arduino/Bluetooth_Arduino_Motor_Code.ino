int Motor_A_Enable = 9;
int Motor_A_Reverse = 3;
int Motor_A_Forward = 4;

int Motor_B_Enable = 10;
int Motor_B_Reverse = 12;
int Motor_B_Forward = 7;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  
  pinMode(Motor_A_Enable, OUTPUT);
  pinMode(Motor_A_Forward, OUTPUT);
  pinMode(Motor_A_Reverse, OUTPUT);

  pinMode(Motor_B_Enable, OUTPUT);
  pinMode(Motor_B_Forward, OUTPUT);
  pinMode(Motor_B_Reverse, OUTPUT);
}

void loop() {

  if(Serial.available() > 0)
  {
    char data;
    data = Serial.read();
    Serial.write(Serial.read());
    Serial.println(data);

    switch (data)
    {
      case 'F': //FORWARD
        analogWrite(Motor_B_Enable, 255);
        analogWrite(Motor_A_Enable, 255);
        digitalWrite(Motor_A_Forward, HIGH);
        digitalWrite(Motor_B_Forward, HIGH);
        digitalWrite(Motor_A_Reverse, LOW);
        digitalWrite(Motor_B_Reverse, LOW);
        
        break;
      case 'B': //REVERSE
        analogWrite(Motor_B_Enable, 255);
        analogWrite(Motor_A_Enable, 255);
        digitalWrite(Motor_A_Forward, LOW);
        digitalWrite(Motor_B_Forward, LOW);
        digitalWrite(Motor_A_Reverse, HIGH);
        digitalWrite(Motor_B_Reverse, HIGH);
        break;
      case 'L'://FORWARD LEFT
        analogWrite(Motor_A_Enable, 0);
         
        analogWrite(Motor_B_Enable, 255);
        digitalWrite(Motor_A_Reverse, LOW);
        digitalWrite(Motor_A_Forward, HIGH);
        break;
      case 'R'://FORWARD RIGHT
        analogWrite(Motor_B_Enable, 0);
        analogWrite(Motor_A_Enable, 255);
        digitalWrite(Motor_B_Reverse, LOW);
        digitalWrite(Motor_B_Forward, HIGH);
        break;
        case 'G': //Reverse Left
        analogWrite(Motor_B_Enable, 0);
        analogWrite(Motor_A_Enable, 0);
        digitalWrite(Motor_B_Reverse, HIGH);
        digitalWrite(Motor_B_Forward, LOW);
        break;
      case 'O': //REVERSE LEFT
        analogWrite(Motor_A_Enable, 255);
        analogWrite(Motor_B_Enable, 0);
        digitalWrite(Motor_A_Reverse, HIGH);
        digitalWrite(Motor_A_Forward, LOW);
        break;
      case '6': //REVERSE RIGHT
        analogWrite(Motor_B_Enable, 255);
        analogWrite(Motor_A_Enable, 0);
        digitalWrite(Motor_B_Reverse, HIGH);
        digitalWrite(Motor_B_Forward, LOW);
        break;
      default: //If bluetooth module receives any value not listed above, both motors turn off
        analogWrite(Motor_A_Enable, 0);
        analogWrite(Motor_B_Enable, 0);
    }
  }
}
