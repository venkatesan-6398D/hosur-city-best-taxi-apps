# Hosur City Best Taxi — Native Android starter projects

Indha ZIP-la rendu separate native Android projects irukku:
- `customer-app/` — customer booking UI starter
- `driver-app/` — driver booking UI starter
- `.github/workflows/build-apks.yml` — GitHub Actions cloud build workflow

## APK cloud-la build panna
1. GitHub-la pudhu repository create pannunga.
2. ZIP extract panni, indha ZIP-oda contents ellathayum repository root-ku upload/push pannunga.
3. GitHub repository -> Actions tab -> "Build Hosur Taxi APKs" -> Run workflow.
4. Build success aana workflow run page-la `taxi-apks` artifact download pannunga.
5. Artifact ZIP-la `customer-app-debug.apk` and `driver-app-debug.apk` irukkum.

## Important
- Idhu initial UI/source-code starter. Real bookings, login, driver accept/reject, live GPS tracking work aaga backend/authentication and location permissions/service implement + test pannanum.
- Existing website/backend automatically connect aagathu. Backend details share panninaal dhaan integrate panna mudiyum.
- APK debug build testing-ku. Public Play Store release-ku signing, privacy policy, permissions and full testing thevai.
- Cloud build-ku GitHub account/repository thevai; build runner Gradle download panna internet access thevai.
