
public class BmiCheck {
  public static void main (String[] args) {
    double lengte, gewicht, bmi;
    lengte = 1.75;
    gewicht = 75.0;
    bmi = gewicht/(lengte*lengte);
    // vergelijk BMI met grenzen: <18, >25, of ertussen in en print kleur
	// In Windows 10 CMD staat kleuroptie standaard uit, om aan te zetten in CMD commando:
	// reg add HKCU\Console /v VirtualTerminalLevel /t REG_DWORD /d 1
	if(bmi<18){
		System.out.println((char)27 + "[93m" +"geel"+ (char)27+"[0m");
		}
	else if(bmi>=25){
		// double value comparison == mogelijke afwijking verwaarloosbaar
		System.out.println((char)27 + "[91m" +"rood"+ (char)27+"[0m");
		}
	else{
		System.out.println((char)27 + "[92m" +"groen"+ (char)27+"[0m");
		}
  }
}