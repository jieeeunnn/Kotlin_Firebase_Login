# Kotlin_Firebase_Login
### firebase Authentication_로그인
#### firebase의 인증 기능(Authentication)을 사용하여 로그인 구현
- 기능
  - LoginActivity에서 사용자 계정과 비밀번호 입력
  - firebase에 저장되어 있는 계정과 일치하면 로그인 성공 (Sign in)
  - firebase에 저장되어 있지 않는 계정으로 sign in을 시도하면 로그인 불가
  - 새로운 계정 추가 가능 (Sign up)
  - 로그인을 하면 MainActivity로 이동, User UID가 표시됨
  - MainActivity에서 Sign Out 버튼을 누르면 로그아웃 후 로그인 화면으로 돌아감
