  function validateFile() {
        console.log("파일 검사");
        const fileInput = document.getElementById('coverfile');
        const file = fileInput.files[0];
        const fileName = fileInput.value;
        const allowedExtensions = /\.(jpg|jpeg|png)$/i;
        const allowedMimeTypes = ['image/jpeg', 'image/png'];

        // 파일 확장자 검사
        if (!allowedExtensions.test(fileName)) {
            alert("파일 형식이 올바르지 않습니다. JPG, JPEG, PNG 파일만 허용됩니다.");
            fileInput.value = ''; // 업로드된 파일 제거
            return false;
        }

        // 파일 MIME 유형 검사
        if (allowedMimeTypes.indexOf(file.type) === -1) {
            alert("파일 형식이 올바르지 않습니다. JPG, JPEG, PNG 파일만 허용됩니다.");
            fileInput.value = ''; // 업로드된 파일 제거
            return false;
        }

        console.log("검사 완료");
        return true;
    }

function validateFileAdmin() {
        console.log("파일 검사");
        const fileInput = document.getElementById('attachfile');
        const file = fileInput.files[0];
        const fileName = fileInput.value;
        const fileExtension = fileName.split('.').pop();
        const allowedExtensions = /\.(jpg|jpeg|png|txt|zip|bz|bz2|hwp|xls|xlsx|doc|docx|ppt|pptx)$/i;
        const allowedMimeTypes = ['image/jpeg', 'image/png', 'application/x-hwp', 'application/vnd.ms-excel', 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet', 'application/msword', 'application/vnd.openxmlformats-officedocument.wordprocessingml.document', 'application/vnd.ms-powerpoint', 'application/vnd.openxmlformats-officedocument.presentationml.presentation', 'text/plain', 'application/x-zip-compressed', 'application/zip', 'application/octet-stream'  ];



        // 파일 확장자 검사
        if (!allowedExtensions.test(fileName)) {
            alert("파일 형식이 올바르지 않습니다1.");
            fileInput.value = ''; // 업로드된 파일 제거
            return false;
        }


        // 파일 MIME 유형 검사
        if (allowedMimeTypes.indexOf(file.type) === -1) {
            alert("파일 형식이 올바르지 않습니다2.");
            fileInput.value = ''; // 업로드된 파일 제거
            return false;
        }

        console.log("검사 완료");
        return true;
}



    function downloadFile(attachFile, uploadFile) {
        // 경로 검증
        console.log('경로검증');
        if (isValidFilename(attachFile) && isValidFilename(uploadFile)) {
            // 폼에 파일 정보 설정
            document.downFrm.attachfile.value = attachFile;
            document.downFrm.uploadfile.value = uploadFile;

            // 폼 제출
            document.downFrm.submit();
        } else {
            alert("잘못된 파일 이름입니다.");
        }
    }
let alertDisplayed = false; //alert표시 여부 확인

    // 파일 이름 검증 함수
    function isValidFilename(filename) {
        console.log('이름검증');
        // 경로 구분자 검사
        if (filename.includes("/") || filename.includes("\\")) {
        if (!alertDisplayed) {
            alertDisplayed = true;
        console.log('중복방지');
}
            return false;
        }
        // 기타 보안 취약점 검사 로직 추가 가능

        return true;
    }
