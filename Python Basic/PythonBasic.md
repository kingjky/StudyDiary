# Python Basic

#### Chapter.0 파이썬 시작하기

- 파이썬의 장점
  - 문법이 쉽다
  - 개발 속도가 빠르다
    - 라이브러리가 다양하다

- 파이썬의 설치
  - http://python.org/

- 파이참의 설치
  - https://www.jetbrains.com/ko-kr/pycharm/

#### Chapter.1 기본 문ㅂ

- print()
  - `print(string, int, arr, ...)`
  - `print(1, 2, 3)`
  - `print('My name is', 'JKY')

- input()
  - 입력받는 기본 명령어
  - input(String)
    - String 이후 입력 받기
  - age = input('당신의 나이는?')
    - age 변수에 입력 값 저장

- Variable
  - Type 없이 변수명으로도 가능
  - 명명규칙 : 일반적



- 참고 할 페이지

  - 파이썬 튜터(http://pythontutor.com/)

  

- DataType

  - `print( type(변수) )`

    - 변수의 타입을 출력한다

  - Numeric

    - float
    - int

  - str (String)

    >  "Hello" 또는 'hello'

    - 순서를 바꿀 수 없다?

    - 여러 줄 입력 가능

      ```python
      my_str = """안녕
      하세요
      모두들
      """
      
      '''이것도
      여러줄
      '''
      ```

    - Formatting 

    > %를 활용한 정규 표현식

    ```python
    my_str = 'My name is %s' % 'Young Choi'
    ```

    

  - Boolean

- Data Structure

  - List
    - 대괄호 [ ] 사용

  ```python
  import random
  
  my_list = [1,2,3]
             print(random.choice(my_list));
  
  my_list[1] = 5
  ```

  - Tuple
    `my_tuple = (1, 2, 3)`
    - 소괄호  () 사용
    - 값 변경 불가
  - Dictionary

  ```python
  my_dict = {'철수':'남', '영희':'여', '동수':'여'}
  
  print(my_dict['동수'])
  
  my_dict['동수'] = '남'
  
  print(my_dict['동수'])
  ```

- 자료형 변경 Function

  > toString, parseInt 와 비슷한 듯 하지만 다름

  - float( 변수 )
  - int( 변수 )
  - str( 변수 )
  - list( String )
    - char list 로 변환

- Comment (주석)

  - `#` 를 사용

  ```python
  print(1+2) # 안녕
  ```

  