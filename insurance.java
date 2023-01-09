//hadeel najim
public class InsuranceCalculator {
  private static final int PREMIUM_UNDER_50_HP = 400;
  private static final int PREMIUM_UP_TO_100_HP = 600;
  private static final double PREMIUM_INCREMENT_PER_HP = 3.80;
  private static final double NEW_SPORTS_CAR_PREMIUM_INCREASE = 1.08;
  private static final double OLD_SPORTS_CAR_PREMIUM_INCREASE = 1.04;
  private static final double STREET_PARKING_PREMIUM_INCREASE = 1.08;
  private static final double GARAGE_PARKING_PREMIUM_DISCOUNT = 0.98;

  public static int calculatePremium(int horsepower, boolean isSportsCar, int age, boolean isParkedInGarage) {
    int basePremium;
    if (horsepower < 50) {
      basePremium = PREMIUM_UNDER_50_HP;
    } else if (horsepower <= 100) {
      basePremium = PREMIUM_UP_TO_100_HP;
    } else {
      basePremium = PREMIUM_UP_TO_100_HP + (int)((horsepower - 100) * PREMIUM_INCREMENT_PER_HP);
    }

    if (isSportsCar) {
      double sportsCarPremiumIncrease = age > 4 ? OLD_SPORTS_CAR_PREMIUM_INCREASE : NEW_SPORTS_CAR_PREMIUM_INCREASE;
      basePremium += basePremium * sportsCarPremiumIncrease;
    }

    if (!isParkedInGarage) {
      basePremium += basePremium * STREET_PARKING_PREMIUM_INCREASE;
    } else {
      basePremium -= basePremium * GARAGE_PARKING_PREMIUM_DISCOUNT;
    }

    return basePremium;
  }
}
