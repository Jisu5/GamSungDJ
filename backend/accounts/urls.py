from django.urls import path
from . import views

app_name = "accounts"
urlpatterns = [
    # social login
    path('google/', views.GoogleLogin.as_view(), name='google_login'),
    path('kakao/', views.KakaoLogin.as_view(), name='kakao_login'),
    # user
    # path('', )
]