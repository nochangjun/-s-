package Project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SurveyBean {
    private int pollId; // 설문 고유 ID
    private String question; // 설문 질문
    private String startDate; // 설문 시작일
    private String endDate; // 설문 종료일
    private int surveyType; // 설문 유형 (1: 단일 선택, 2: 복수 선택)
    private int isActive; // 활성화 여부 (1: 활성, 0: 비활성)
    private String createdAt; // 설문 생성일 (추가된 필드)

    // 항목 리스트 추가
    private List<Item> items; // 설문 항목 리스트로 Item 객체 사용

    // Constructor
    public SurveyBean() {
        items = new ArrayList<>(); // 항목 리스트 초기화
    }

    // 항목을 추가하는 메서드
    public void addItem(Item item) {
        items.add(item); // Item 객체를 리스트에 추가
    }

    // Getter and Setter Methods
    public int getPollId() {
        return pollId;
    }

    public void setPollId(int pollId) {
        this.pollId = pollId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(int surveyType) {
        this.surveyType = surveyType;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<Item> getItems() {
        return items;
    }

    // 설문이 만료되었는지 확인
    public boolean isExpired() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date endDate = sdf.parse(this.endDate);
            return now.after(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return false; // 날짜 변환 실패시 false 반환
        }
    }

    // Item 클래스 정의
    public static class Item {
        private String content; // 항목 내용
        private int voteCount; // 해당 항목의 투표 수
        private int itemListNum; // 항목 고유 번호

        // Item 생성자
        public Item(String content, int voteCount, int itemListNum) {
            this.content = content;
            this.voteCount = voteCount;
            this.itemListNum = itemListNum;
        }

        // Item의 Getter 메서드
        public String getContent() {
            return content;
        }

        public int getVoteCount() {
            return voteCount;
        }

        public int getItemListNum() {
            return itemListNum;
        }
    }

    @Override
    public String toString() {
        return "SurveyBean [pollId=" + pollId + ", question=" + question + ", startDate=" + startDate + ", endDate="
                + endDate + ", surveyType=" + surveyType + ", isActive=" + isActive + ", createdAt=" + createdAt + ", items=" + items + "]";
    }
}
