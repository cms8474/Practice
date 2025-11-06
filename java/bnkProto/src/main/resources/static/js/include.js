/* ============================================
   include.js - HTML 파일 include 유틸리티
   ============================================ */

// HTML 파일을 include하는 함수
async function includeHTML(elementId, filePath) {
    try {
        const response = await fetch(filePath);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const html = await response.text();
        const element = document.getElementById(elementId);
        if (element) {
            element.innerHTML = html;
        }
    } catch (error) {
        console.error('Error including HTML:', error);
    }
}

// 페이지 로드 시 자동으로 include 실행
document.addEventListener('DOMContentLoaded', function() {
    // header include
    const headerPlaceholder = document.getElementById('header-placeholder');
    if (headerPlaceholder) {
        includeHTML('header-placeholder', '/include/header.html');
    }
    
    // footer include
    const footerPlaceholder = document.getElementById('footer-placeholder');
    if (footerPlaceholder) {
        includeHTML('footer-placeholder', '/include/footer.html');
    }
});

