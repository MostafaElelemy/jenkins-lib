def call(Map cfg = [:]) {
  String goals = cfg.get('goals', '-B -q clean test package')
  String jdk   = cfg.get('jdk',   'jdk17')
  String mvn   = cfg.get('maven', 'maven-3.9')

  def JDK   = tool jdk
  def MAVEN = tool mvn

  withEnv(["JAVA_HOME=${JDK}", "PATH+JAVA=${JDK}/bin", "PATH+MAVEN=${MAVEN}/bin"]) {
    sh "mvn ${goals}"
  }

  // تقارير و artifacts
  junit 'target/surefire-reports/*.xml'
  archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
}
