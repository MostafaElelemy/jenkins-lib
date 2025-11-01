package org.acme

class Utils {
  static void gate(script, int buildNumber) {
    if (buildNumber < 5) {
      script.error("Gate: BUILD_NUMBER " + buildNumber + " < 5")
    }
  }
}
