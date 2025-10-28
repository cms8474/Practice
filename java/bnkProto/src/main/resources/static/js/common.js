/* ============================================
   common.js - 공통 JavaScript 함수
   ============================================ */

// 현재 날짜를 YYYY-MM-DD 형식으로 반환
function getCurrentDate() {
    const today = new Date();
    const year = today.getFullYear();
    const month = String(today.getMonth() + 1).padStart(2, '0');
    const day = String(today.getDay()).padStart(2, '0');
    return `${year}-${month}-${day}`;
}

// 숫자를 천단위 콤마가 있는 형식으로 변환
function formatNumber(num) {
    return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

// 계좌번호를 마스킹 처리 (뒤 4자리만 보이게)
function maskAccountNumber(accountNumber) {
    if (!accountNumber || accountNumber.length < 5) return accountNumber;
    const visibleLength = 4;
    const masked = '*'.repeat(accountNumber.length - visibleLength);
    return masked + accountNumber.slice(-visibleLength);
}

// 전화번호를 포맷팅 (010-1234-5678 형식)
function formatPhoneNumber(phone) {
    const cleaned = phone.replace(/[^0-9]/g, '');
    if (cleaned.length === 11) {
        return cleaned.replace(/(\d{3})(\d{4})(\d{4})/, '$1-$2-$3');
    } else if (cleaned.length === 10) {
        return cleaned.replace(/(\d{3})(\d{3})(\d{4})/, '$1-$2-$3');
    }
    return phone;
}

// 메시지 알림 (간단한 alert 대신 사용)
function showMessage(message, type = 'info') {
    // 실제 구현에서는 더 예쁜 알림 컴포넌트 사용
    alert(message);
}

// 페이지 로드 시 실행되는 초기화 함수
document.addEventListener('DOMContentLoaded', function() {
    // 모든 입력 필드에 자동 포커스 처리
    const inputFields = document.querySelectorAll('input[type="text"], input[type="password"], input[type="email"], input[type="tel"]');
    inputFields.forEach(input => {
        input.addEventListener('focus', function() {
            this.style.borderColor = 'var(--main-color)';
        });
        input.addEventListener('blur', function() {
            this.style.borderColor = '';
        });
    });
    
    // 브라우저 호환성을 위한 polyfill
    if (!String.prototype.padStart) {
        String.prototype.padStart = function(maxLength, fillString) {
            return this.length >= maxLength ? this : (fillString || ' ').repeat(maxLength - this.length) + this;
        };
    }
});

// 모바일 메뉴 토글
function toggleMobileMenu() {
    const nav = document.querySelector('.nav');
    nav.classList.toggle('mobile-open');
}

// 스크롤 시 헤더 스타일 변경
window.addEventListener('scroll', function() {
    const header = document.querySelector('.header');
    if (window.scrollY > 100) {
        header.style.boxShadow = '0 4px 12px rgba(0, 0, 0, 0.1)';
    } else {
        header.style.boxShadow = '0 2px 8px rgba(0, 0, 0, 0.05)';
    }
});

