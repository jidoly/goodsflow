function confirmAndDelete(id) {
    if (confirm('삭제하시겠습니까?')) {
        fetch(`/rest/cancel/${id}`, {
            method: 'DELETE'
        }).then(response => {
            if (response.ok) {
                // 삭제가 성공하면 추가적인 로직을 수행할 수 있습니다.
                console.log('삭제 성공');
                location.reload();
            } else {
                console.error('삭제 실패');
            }
        });
    }
}