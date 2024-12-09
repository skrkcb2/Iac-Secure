
// 토큰 저장 함수
function saveTokens(accessToken, refreshToken) {
    // access_token과 refresh_token을 localStorage에 저장
    localStorage.setItem('accessToken', accessToken);
    localStorage.setItem('refreshToken', refreshToken);
}

// 토큰 삭제 함수
function deleteTokens() {
    console.log("토큰삭제함수");
    // localStorage에서 access_token과 refresh_token 삭제
    localStorage.removeItem('accessToken');
    localStorage.removeItem('refreshToken');
}
// 토큰 가져오기 함수


